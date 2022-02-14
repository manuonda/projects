


const baseURL = `${process.env.REACT_APP_API_URL}/api/`;


const fetchWith  = async (endpoint, data, method = 'GET' ) =>  {
   

    let url = `${baseURL}${endpoint}`;

    // para token 
   // const token = localStorage.getItem('token');
   
   if ( method === 'GET') {
    const resp = await  fetch(url, {
        method: method
    });
    console.log(resp.status);
    return resp;
    
   } else if ( method === 'POST' || method === 'PUT') {
       const resp = await fetch(url, {
           method,
           headers: {
            'Content-Type': 'application/json',
           },
           body: JSON.stringify(data)
       });
       return resp;
   }
};

export {
    fetchWith,
}