import axios from 'axios';
import  {  useEffect, useState } from 'react';
import {ToastContainer, toast } from 'react-toastify';
import { useHistory } from "react-router-dom";
import {
    Container, Col, Form,
    FormGroup, Label, Input,
    Button, Row
  } from 'reactstrap';

const VerifyUser=()=>{
    let history = useHistory();
        const [user,setuser] = useState({});
       
        const [reguser,setReguser] = useState({});
       useEffect(()=>{
           setReguser(JSON.parse(localStorage.getItem("reg_user")));

       },[]);
// console.log("from rporps" , props.username);
    const handleForm =(e) =>{
console.log(user);

axios.post(`http://localhost:8080/verify`,user).then(
(response)=>{
    console.log(response.data);
if(response.status===200){
    toast.success("login success");

// localStorage.setItem("user",JSON.stringify(response.data));
   history.push("/login")
}
},(error)=>{
    console.log(error);
    toast.error("something went wrong");
}
);
        e.preventDefault();   
    }
    
        return (
            <Container>
                <ToastContainer />
                <Row>
                    <h1 className="text-center">Verify OTP Page</h1>
                    </Row>
                    <Row>
                    <Col>
            <Form onSubmit={handleForm}>
            <FormGroup>
              <Label for="exampleEmail">Email</Label>
              <Input type="email" name="email" id="exampleEmail" placeholder="Email" onChange={(e)=>{
                  setuser({...user,email:e.target.value});
              }} />
            </FormGroup>
            <FormGroup>
              <Label for="exampleOtp">Otp</Label>
              <Input type="text" name="Otp" id="exampleOtp" placeholder="Otp" onChange={(e)=>{
                  setuser({...user,otp:e.target.value});
              }} />
            </FormGroup>
            <Button className="position-relative start-50 my-2" color="primary">Submit</Button>
          </Form>
          </Col>
                </Row>
          </Container>
          );
      }

export default VerifyUser;