
import { format } from 'date-fns';
import HttpClientWrapper from '../../../api/http-client-wrapper';
import { PublishedData } from './publisheddata-payload';




class PublishedApiService {
    private httpClientWrapper: HttpClientWrapper;

    constructor() {
        this.httpClientWrapper = new HttpClientWrapper();
    }

    async getCustomDate(startDate: Date, endDate: Date): Promise<PublishedData[]> {
        try {
            const formattedStartDate = format(startDate, 'yyyy-MM-dd');
            const formattedEndDate = format(endDate, 'yyyy-MM-dd');
    
            const response = await this.httpClientWrapper.get(`/api/v1/PublishedDt?fromDate=${formattedStartDate}&toDate=${formattedEndDate}`);

            
            return response;
    } catch (error: any) {
        if (error.response) {
            console.error('Request failed with status code:', error.response.status);
            console.error('Response data:', error.response.data);
        } else if (error.request) {
            console.error('No response received. Request made but no response.');
        } else {
            console.error('Error setting up the request:', error.message);
        }
        throw new Error(`Error in API request: ${error}`);
    }
}

}

export default PublishedApiService;