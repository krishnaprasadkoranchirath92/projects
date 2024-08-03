import React, { useState } from 'react'
import userService from './service/user.service';

function RegisterationForm() {
    const [user, setUser] = useState({
        userName: "",
        email: "",
        mobile: "",
        address: "",
    });
    const [msg, setMsg] = useState("")

    const handleChange = (e) => {
        const value = e.target.value;
        setUser({ ...user, [e.target.name]: value })
    }

    const RegisterUser = (e) => {
        e.preventDefault();
        console.log(user);
        userService.saveUser(user)
            .then((res) => {
                console.log("User Added Successfully");
                setMsg("Used Added Sucessfully");
                setUser({
                    userName: "",
                    email: "",
                    mobile: "",
                    address: "",
                })
            }).catch((error) => {
                console.log(error);
            });
    }
    return (
        <>
            <div className='container mt-3'>
                <div className='row'>
                    <div className='col-md-6 offset-md-3'>
                        <div className='card'>
                            <div className='card-header fs-3 text-center'>
                                Register User
                            </div>
                            {msg && <p className="fs-4 text-center text-success">{msg}</p>}
                            <div className='card-body'>
                                <form onSubmit={(e) => RegisterUser(e)}>
                                    <div className='mb-3'>
                                        <label>Enter UserName</label>
                                        <input type="text" name="userName" className='form-control' onChange={(e) => handleChange(e)}
                                            value={user.userName} />
                                    </div>
                                    <div className='mb-3'>
                                        <label>Enter Email</label>
                                        <input type="text" name="email" className='form-control'
                                            onChange={(e) => handleChange(e)}
                                            value={user.email} />
                                    </div>
                                    <div className='mb-3'>
                                        <label>Enter mobile No</label>
                                        <input type="text" name="mobile" className='form-control'
                                            onChange={(e) => handleChange(e)}
                                            value={user.mobile} />
                                    </div>
                                    <div className='mb-3'>
                                        <label>Enter Address</label>
                                        <input type="text" name="address" className='form-control'
                                            onChange={(e) => handleChange(e)}
                                            value={user.address} />
                                    </div>
                                    <button className="btn btn-primary col-md-12">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default RegisterationForm