import React, { useState, useEffect } from 'react';
import { Grid, TextField, Paper } from '@mui/material';
import { Modal, Button, Col, Row } from 'react-bootstrap';
import AddressApiService from '../../data/services/insert/address-api-service';

interface PdfModalProps {
    pathId?: number;
    associatedId?: number;
    companyId?: number;
    show: boolean;
    onHide: () => void;
    pdfBase64: string | null;
    onBlockClick: () => void;
    blockButtonText: string;
    editButtonText: string;
    blockButtonDisableds: boolean;
    editButtonDisabled: boolean;
    personIndex: number;
    person: any;
    handleFileChange3: (personIndex: number, index: number, event: React.ChangeEvent<HTMLInputElement>) => void;
    handleChoosecompanyImagesClick3: (personIndex: number, index: number) => void;
}

interface MultipartFile {
    name: string;
    size: number;
    type: string;
    file: File;
}

const PdfModal: React.FC<PdfModalProps> = ({
    pathId,
    associatedId,
    companyId,
    show,
    onHide,
    pdfBase64,
    onBlockClick,
    blockButtonText,
    editButtonText,
    blockButtonDisableds,
    editButtonDisabled,
    personIndex,
    person,
    handleFileChange3,
    handleChoosecompanyImagesClick3,
}) => {
    const [isEditing, setIsEditing] = useState(false);
    const [companyDocuments, setCompanyDocuments] = useState<MultipartFile[]>([]);
    const addressApiService = new AddressApiService();

    useEffect(() => {
        console.log('Company documents:', companyDocuments);
    }, [companyDocuments]);

    const handleFileInputChange = (index: number, event: React.ChangeEvent<HTMLInputElement>) => {
        const files = event.target.files;
        if (files && files.length > 0) {
            const selectedFile = files[0];
            setCompanyDocuments(prevDocs => {
                const newDocs = [...prevDocs];
                newDocs[index] = {
                    name: selectedFile.name,
                    size: selectedFile.size,
                    type: selectedFile.type,
                    file: selectedFile,
                };
                return newDocs;
            });
        }
    };

    const handleChooseImagesClick = (index: number) => {
        const fileInput = document.getElementById(`file-input-${index}`) as HTMLInputElement;
        if (fileInput) fileInput.click();
    };

    const handleSave = async () => {
        if (!pathId || !associatedId || !companyId) {
            console.log('Path ID or Associated ID is missing');
            return;
        }

        const files = companyDocuments.map(doc => doc.file);
        const pathIds = [pathId];
        const associatedIds = [associatedId];
        const companyIds = [companyId];

        console.log('files documents:', files);
        console.log('pathIds:', pathIds);
        console.log('associatedIds:', associatedIds);

        try {
            const response = await addressApiService.uploadFiles(files, pathIds, associatedIds, companyIds);
            console.log('Response:', response);
            console.log('Files uploaded successfully');
            onHide();
        } catch (error) {
            console.error('Upload error:', error);
            console.log('Failed to upload files');
        }
    };


    const handleBlockClick = async () => {
        try {
            if (associatedId) {
                const response = await addressApiService.blockCompanyDocument(associatedId);
                console.log('Block response:', response);
                console.log('Director blocked successfully.');
            } else {
                console.log('Associated ID is missing.');
            }
            onHide();
        } catch (error) {
            console.error('Error blocking director:', error);
            console.log('Failed to block director.');
        }
    };

    return (
        <Modal show={show} onHide={onHide} size="xl" centered>
            <Modal.Header closeButton>
                <Modal.Title>{isEditing ? 'Edit Document' : 'Document PDF'}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {isEditing ? (
                    <Grid container spacing={2}>
                        {person.companyDocumentsDTOS?.map((doc: { imageName3: string }, index: number) => (
                            <Grid item xs={12} key={index}>
                                <Paper style={{ padding: 16 }}>
                                    <Grid container spacing={2} alignItems="center">
                                        <Grid item xs={6}>
                                            <input
                                                id={`file-input-${index}`}
                                                type="file"
                                                onChange={(event) => handleFileInputChange(index, event)}
                                                style={{ display: 'none' }}
                                            />
                                            <Button
                                                size="sm"
                                                variant="outlined"
                                                onClick={() => handleChooseImagesClick(index)}
                                            >
                                                Choose Image
                                            </Button>
                                        </Grid>
                                        <Grid item xs={6}>
                                            <TextField
                                                label="File Name"
                                                value={companyDocuments[index]?.name || doc.imageName3 || ''}
                                                disabled
                                                fullWidth
                                            />
                                        </Grid>
                                    </Grid>
                                </Paper>
                            </Grid>
                        ))}
                    </Grid>
                ) : (
                    pdfBase64 ? (
                        <iframe
                            src={`data:application/pdf;base64,${pdfBase64}`}
                            style={{ width: '100%', height: '600px', border: 'none' }}
                            title="Document PDF"
                        />
                    ) : (
                        <p>No PDF available</p>
                    )
                )}
            </Modal.Body>
            <Modal.Footer>
                <Button
                    variant="secondary"
                    onClick={() => {
                        if (isEditing) {
                            setIsEditing(false);
                        } else {
                            handleBlockClick();
                        }
                    }}
                    disabled={blockButtonDisableds}
                >
                    {blockButtonText}
                </Button>
                <Button
                    variant="primary"
                    onClick={() => {
                        if (isEditing) {
                            handleSave();
                            setIsEditing(false);
                        } else {
                            setIsEditing(true);
                        }
                    }}
                    disabled={editButtonDisabled}
                >
                    {isEditing ? 'Save' : editButtonText}
                </Button>
                {isEditing && (
                    <Button
                        variant="warning"
                        onClick={() => setIsEditing(false)}
                    >
                        Back
                    </Button>
                )}
                <Button
                    variant="danger"
                    onClick={onHide}
                >
                    Close
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default PdfModal;

