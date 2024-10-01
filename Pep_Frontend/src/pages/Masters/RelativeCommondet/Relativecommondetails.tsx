
import React, { useState, useEffect } from 'react';
import {
    TextField, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow,
    Grid, Button, IconButton, Box, Dialog, DialogTitle, DialogContent, Container, DialogActions, Snackbar, Card
} from '@mui/material';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';

import MuiAlert from '@mui/material/Alert';
import TablePagination from '@mui/material/TablePagination';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import RelativeCommondetApiService from '../../../data/services/master/RelativeCommondet/relativecommondet-api-service';
import Header from '../../../layouts/header/header';
import { RelativeCommondetPayload } from '../../../data/services/master/RelativeCommondet/relativecommondet-payload';
interface RelativeCommondet {
    id: string;
    commonName: string;
}

const RelativeCommondet = () => {
    const [name, setName] = useState('');
    const [selectedcommondet, setSelectedcommondet] = useState('');
    const [commondet, setCommondet] = useState<RelativeCommondet[]>([]);
    const [openEditDialog, setOpenEditDialog] = useState(false);
    const [editcommondetName, setEditcommondetName] = useState('');
    const [editcommondetId, setEditcommondetId] = useState('');
    const [openDeleteDialog, setOpenDeleteDialog] = useState(false);
    const [deletecommondetId, setDeletecommondetId] = useState('');
    const [successMessage, setSuccessMessage] = useState('');
    const [isSuccessOpen, setIsSuccessOpen] = useState(false);
    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(5);
    const [activeTab, setActiveTab] = useState('insert'); // Track the active tab
    const [serialNumber, setSerialNumber] = useState(1);
    const [errorMessage, setErrorMessage] = useState('');
    const [isErrorOpen, setIsErrorOpen] = useState(false);
    const [dialogAction, setDialogAction] = useState<string | null>(null);
    const [dialogOpen, setDialogOpen] = useState(false);
    const [selectedRowId, setSelectedRowId] = useState<string | null>(null);
    const [blockedRows, setBlockedRows] = useState<string[]>([]);
    const authService = new RelativeCommondetApiService();
    useEffect(() => {
        fetchCommondet();
        const storedBlockedRows = localStorage.getItem('blockedRows');
        if (storedBlockedRows) {
            setBlockedRows(JSON.parse(storedBlockedRows) as string[]); // Parse as an array of strings
        }
    }, []);

    const showSuccessMessage = (message: string) => {
        setSuccessMessage(message);
        setIsSuccessOpen(true);
    };

    const showErrorMessage = (message: string) => {
        setErrorMessage(message);
        setIsErrorOpen(true);
    };
    const handleSubmit = async (e: React.FormEvent) => {
      e.preventDefault();
      if (!name) {
          showErrorMessage('Please fill out all fields.');
          return;
      }
  
      try {
          const payload: RelativeCommondetPayload = {
              commonName: name
          };
  
          const response = await authService.doRelativeCommondet(payload);
  
          setName('');
          fetchCommondet(); // Update the table data
          showSuccessMessage('RelativeCommondet added successfully.');
      } catch (error) {
          console.error("Error adding RelativeCommondet:", error);
      }
  };
  

    const fetchCommondet = async () => {
        try {
            const Commondet = await authService.getRelativeCommondet();
            setCommondet(Commondet);
            setSerialNumber(page * rowsPerPage + 1);
        } catch (error) {
            console.error("Error fetching RelativeCommondet:", error);
        }
    };

    const handleEditClick = (id: string, name: string) => {
        setEditcommondetId(id);
        setEditcommondetName(name);
        setOpenEditDialog(true);
    };

    const handleEditDialogClose = () => {
        setOpenEditDialog(false);
        setEditcommondetId('');
        setEditcommondetName('');
    };

    const handleEditDialogSave = async () => {
        try {
            const payload: RelativeCommondetPayload = {
              commonName: editcommondetName
            };
            await authService.updateRelativeCommondet(Number(editcommondetId), payload);
            setOpenEditDialog(false);
            setEditcommondetId('');
            setEditcommondetName('');
            fetchCommondet();
            showSuccessMessage('RelativeCommondet updated successfully.');
        } catch (error) {
            console.error("Error editing RelativeCommondet:", error);
        }
    };
    const handleUnblock = (id: string) => {
        setSelectedRowId(id);
        setDialogAction('unblock');
        setDialogOpen(true);
    };

    const handleBlock = (id: string) => {
        setSelectedRowId(id);
        setDialogAction('block');
        setDialogOpen(true);
    };


    const handleConfirmDialog = async (confirmed: boolean) => {
        if (confirmed && selectedRowId !== null) {
            if (dialogAction === 'block') {
                await blockRow(selectedRowId);
            } else if (dialogAction === 'unblock') {
                await unblockRow(selectedRowId);
            }
        }
        setSelectedRowId(null);
        setDialogOpen(false);
        setDialogAction(null);
    };
    const blockRow = async (id: string) => {
        try {
            await authService.blockRelativeCommondet(Number(id));
            setBlockedRows([...blockedRows, id]);
            localStorage.setItem('blockedRows', JSON.stringify([...blockedRows, id]));
            showSuccessMessage('RelativeCommondet blocked successfully.');

        } catch (error) {
            console.error("Error blocking RelativeCommondet:", error);
        }
    };

    const unblockRow = async (id: string) => {
        try {
            await authService.unblockRelativeCommondet(Number(id));
            setBlockedRows(blockedRows.filter((rowId) => rowId !== id));
            localStorage.setItem('blockedRows', JSON.stringify(blockedRows.filter((rowId) => rowId !== id)));
            showSuccessMessage('RelativeCommondet unblocked successfully.');
        } catch (error) {
            console.error("Error unblocking RelativeCommondet:", error);
        }
    };
    const handleDialogCancel = () => {
        setSelectedRowId(null);
        setDialogOpen(false);
        setDialogAction(null);
    };

    const handlePageChange = (event: React.MouseEvent<HTMLButtonElement> | null, newPage: number) => {
        setPage(newPage);
        setSerialNumber(newPage * rowsPerPage + 1);
    };

    const handleRowsPerPageChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

    const startIndex = page * rowsPerPage;
    const endIndex = startIndex + rowsPerPage;

    return (
        <>
            <Header />
            <Box m={6}>
                <Container style={{ maxWidth: 'none', backgroundColor: 'white', padding: "30px", margin: "10px" }}>
                    <Box m={4}>
                        <h3>RelativeCommondet</h3>
                        <div className="d-flex justify-content-center">
                            <div className="card" style={{ boxShadow: '1px 1px 1px grey', width: '100%' }}>
                                <div className="card-body">
                                    <ul className="nav gap-2 p-1 small shadow-sm">
                                        <li className="nav-item" role="presentation">
                                            <button
                                                className={`nav-link ${activeTab === 'insert' ? 'active btn btn-outline-primary' : 'btn btn-outline-primary'}`}
                                                onClick={() => setActiveTab('insert')}
                                                type="button"
                                            >
                                                INSERT
                                            </button>
                                        </li>
                                        <li className="nav-item" role="presentation">
                                            <button
                                                className={`nav-link ${activeTab === 'edit' ? 'active btn btn-outline-primary' : 'btn btn-outline-primary'}`}
                                                onClick={() => setActiveTab('edit')}
                                                type="button"
                                            >
                                                EDIT
                                            </button>
                                        </li>
                                        <li className="nav-item" role="presentation">
                                            <button
                                                className={`nav-link ${activeTab === 'unblock' ? 'active btn btn-outline-primary' : 'btn btn-outline-primary'}`}
                                                onClick={() => setActiveTab('unblock')}
                                                type="button"
                                            >
                                                UNBLOCK
                                            </button>
                                        </li>
                                    </ul>
                                    {activeTab === 'insert' && (
                                        <div className="nav gap-2 p-3 small shadow-sm">
                                            <Grid container spacing={3} alignItems="center" justifyContent="center">
                                                <Grid item xs={12} sm={4}>
                                                    <h6>Add RelativeCommondet</h6>
                                                    <Box>
                                                        <TextField
                                                            id="filled-basic"
                                                            label="RelativeCommondet"
                                                            className="text-field"
                                                            value={name}
                                                            onChange={(e) => setName(e.target.value)}
                                                            variant="outlined"
                                                            margin="dense"
                                                            size="small"
                                                            fullWidth
                                                        />
                                                    </Box>
                                                    <Grid container spacing={3} alignItems="center" justifyContent="center">
                                                        <Grid item xs={12} sm={4}>
                                                            <Box mt={2}>
                                                                <button type="button" className="btn btn-outline-primary" onClick={handleSubmit} style={{ textAlign: 'center' }}>
                                                                    Submit
                                                                </button>
                                                            </Box>
                                                        </Grid>
                                                    </Grid>
                                                </Grid>
                                            </Grid>
                                        </div>
                                    )}
                                    {activeTab === 'edit' && (
                                        <div className="card-body">
                                            <Grid container spacing={1} alignItems="center" justifyContent="center">
                                                <TableContainer component={Card} sx={{ maxHeight: 440 }} style={{ width: "85%", margin: "20px" }}>
                                                    <Table size="small" aria-label="a dense table" style={{ margin: '0 auto' }}>
                                                        <TableHead sx={{ backgroundColor: '#cccdd1' }}>
                                                            <TableRow className="tableHeading">
                                                                <TableCell>S.No</TableCell>
                                                                <TableCell>Name</TableCell>
                                                                <TableCell>Action</TableCell>
                                                            </TableRow>
                                                        </TableHead>
                                                        <TableBody>
                                                            {commondet.filter((commondet) => !blockedRows.includes(commondet.id))
                                                                .slice(startIndex, endIndex).map((commondet, index) => (
                                                                    <TableRow key={commondet.id} sx={{ backgroundColor: index % 2 === 0 ? 'white' : '#e1e1e3' }}>
                                                                        <TableCell>{serialNumber + index}</TableCell>
                                                                        <TableCell>{commondet.commonName}</TableCell>
                                                                        <TableCell>
                                                                            <Button
                                                                                onClick={() => handleEditClick(commondet.id, commondet.commonName)}
                                                                                style={{ padding: '1px 1px', marginRight: '4px' }}
                                                                                startIcon={<EditIcon />}
                                                                                variant="outlined"
                                                                                disabled={blockedRows.includes(commondet.id)}
                                                                            >
                                                                                Edit
                                                                            </Button>

                                                                            <Button variant="outlined" onClick={() => handleBlock(commondet.id)} style={{ padding: '1px 1px', marginRight: '4px' }}>
                                                                                Block
                                                                            </Button>
                                                                        </TableCell>
                                                                    </TableRow>
                                                                ))}
                                                        </TableBody>
                                                    </Table>
                                                </TableContainer>
                                                <div >
                                                    <TablePagination
                                                        rowsPerPageOptions={[5, 10, 20]}
                                                        component="div"
                                                        count={commondet.length}
                                                        page={page}
                                                        onPageChange={handlePageChange}
                                                        rowsPerPage={rowsPerPage}
                                                        onRowsPerPageChange={handleRowsPerPageChange}
                                                        style={{ marginLeft: "500px" }}
                                                    />
                                                </div>
                                            </Grid>
                                        </div>
                                    )}
                                    {activeTab === 'unblock' && (
                                        <div className="card-body">
                                            <TableContainer component={Card} sx={{ maxHeight: 440 }}>
                                                <Table size="small" aria-label="a dense table" >
                                                    <TableHead sx={{ backgroundColor: '#cccdd1' }}>
                                                        <TableRow className="tableHeading" >
                                                            <TableCell >S.No</TableCell>
                                                            <TableCell >Name</TableCell>
                                                            <TableCell>Action</TableCell>
                                                        </TableRow>
                                                    </TableHead>
                                                    <TableBody>
                                                        {commondet
                                                            .filter((commondet) => blockedRows.includes(commondet.id))
                                                            .slice(startIndex, endIndex)
                                                            .map((commondet, index) => (
                                                                <TableRow key={commondet.id} sx={{ backgroundColor: index % 2 === 0 ? 'white' : '#e1e1e3' }}>
                                                                    <TableCell>{serialNumber + index}</TableCell>
                                                                    <TableCell>{commondet.commonName}</TableCell>
                                                                    <TableCell>
                                                                        <Button
                                                                            onClick={() => handleEditClick(commondet.id, commondet.commonName)}
                                                                            style={{ padding: '1px', marginRight: '4px' }}
                                                                            startIcon={<EditIcon />}
                                                                            variant="outlined"
                                                                            disabled={blockedRows.includes(commondet.id)}
                                                                        >
                                                                            Edit
                                                                        </Button>
                                                                        <Button variant="outlined" onClick={() => handleUnblock(commondet.id)} style={{ padding: '1px 1px', marginRight: '4px' }}>
                                                                            Unblock
                                                                        </Button>                                                                </TableCell>
                                                                </TableRow>
                                                            ))}
                                                    </TableBody>
                                                </Table>
                                                <TablePagination
                                                    rowsPerPageOptions={[5, 10, 25]} // You can customize the available rows per page options
                                                    component="div"
                                                    count={blockedRows.length} // Total number of rows
                                                    rowsPerPage={rowsPerPage}
                                                    page={page}
                                                    onPageChange={(event, newPage) => setPage(newPage)}
                                                    onRowsPerPageChange={(event) => {
                                                        setRowsPerPage(parseInt(event.target.value, 10));
                                                        setPage(0);
                                                    }}
                                                />
                                            </TableContainer>
                                        </div>
                                    )}
                                </div>
                            </div>
                        </div>
                    </Box>
                </Container>
            </Box>
            <Dialog open={openEditDialog} onClose={handleEditDialogClose}>
                <DialogTitle>Edit RelativeCommondet</DialogTitle>
                <DialogContent>
                    <TextField
                        label="RelativeCommondet Name"
                        fullWidth
                        variant="outlined"
                        margin="dense"
                        value={editcommondetName}
                        onChange={(e) => setEditcommondetName(e.target.value)}
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleEditDialogClose} color="primary">
                        Cancel
                    </Button>
                    <Button onClick={handleEditDialogSave} color="primary">
                        Save
                    </Button>
                </DialogActions>
            </Dialog>
            <Dialog open={dialogOpen} onClose={handleDialogCancel}>
                <DialogTitle>
                    {dialogAction === 'block' ? 'Block State' : 'Unblock State'}
                </DialogTitle>
                <DialogContent>
                    <p>
                        Are you sure you want to {dialogAction === 'block' ? 'block' : 'unblock'} this state?
                    </p>
                </DialogContent>
                <DialogActions>
                    <Button onClick={() => handleConfirmDialog(false)} color="primary">
                        Cancel
                    </Button>
                    <Button onClick={() => handleConfirmDialog(true)} color="primary" autoFocus>
                        Confirm
                    </Button>
                </DialogActions>
            </Dialog>
            <Snackbar
                open={isSuccessOpen}
                autoHideDuration={5000}
                onClose={() => setIsSuccessOpen(false)}
                anchorOrigin={{
                    vertical: 'top',
                    horizontal: 'right',
                }}
            >
                <MuiAlert
                    elevation={6}
                    variant="filled"
                    severity="success"
                    onClose={() => setIsSuccessOpen(false)}
                >
                    {successMessage}
                </MuiAlert>
            </Snackbar>
            <Snackbar
                open={isErrorOpen}
                autoHideDuration={5000}
                onClose={() => setIsErrorOpen(false)}
                anchorOrigin={{
                    vertical: 'top',
                    horizontal: 'right',
                }}
            >
                <MuiAlert
                    elevation={6}
                    variant="filled"
                    severity="error"
                    onClose={() => setIsErrorOpen(false)}
                >
                    {errorMessage}
                </MuiAlert>
            </Snackbar>
        </>
    );
};

export default RelativeCommondet;
