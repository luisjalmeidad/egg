import axios from "axios";

export async function loginUser(email, password) {
    const res = await axios.post(`http://localhost:8080/login`,{
        email,password
    })
    return res.data
}