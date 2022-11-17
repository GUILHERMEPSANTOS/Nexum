import { api } from '../api';


const getFreelancerById = async (id = 1) => {
    const response = await api.get(`/api/v1/freelancer/${id}`);

    return response.data;
}



export { getFreelancerById }