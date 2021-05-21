import axios from 'axios';
import  {  useState } from 'react';
import {ToastContainer, toast } from 'react-toastify';
import { useHistory } from "react-router-dom";
import {
    Container, Col, Form,
    FormGroup, Label, Input,
    Button, Row
  } from 'reactstrap';

const Login=(props)=>{
    let history = useHistory();
        const [user,setuser] = useState({});
// console.log("from rporps" , props.username);
    const handleForm =(e) =>{
// console.log(user);
axios.post(`http://localhost:8080/login`,user).then(
(response)=>{
    // console.log(response);
// console.log(response.data);
//  console.log(response.status)
if(response.status===200){
    toast.success("login success");

localStorage.setItem("user",JSON.stringify(response.data));
   history.push("/profile")
//    history.push({ 
//     pathname: '/profile',
//     user : user
//    });
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
                    <h1 className="text-center">Login Page</h1>
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
              <Label for="examplePassword">Password</Label>
              <Input type="password" name="password" id="examplePassword" placeholder="password" onChange={(e)=>{
                  setuser({...user,password:e.target.value});
              }} />
            </FormGroup>
            <Button className="position-relative start-50 my-2" color="primary">Submit</Button>
          </Form>
          </Col>
                </Row>
          </Container>
          );
      }

export default Login;