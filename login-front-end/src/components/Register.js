import axios from 'axios';
import { useState } from 'react';
import { useHistory } from 'react-router';
import {
    Container, Col, Form,
    FormGroup, Label, Input,
    Button,Row
  } from 'reactstrap';

const Register=()=>{

  const [user,setuser] = useState({});
 const history = useHistory();
  const handleForm =(e) =>{
    setuser({...user,role:{roleName:"admin"}})
console.log(user);
axios.post(`http://localhost:8080/register`,user).then(
(response)=>{
console.log(response.data);
console.log(response.status)
if(response.status===200){
  console.log("register success");
  localStorage.setItem("reg_user",JSON.stringify(response.data));
  history.push("/verify");
}
},(error)=>{
  console.log(error);
}
);
      e.preventDefault();   
  }
        return (
            <Container>
                <Row>
                    <h1 className="text-center">Register Page</h1>
                    </Row>
                    <Row>
                    <Col>
            <Form onSubmit={handleForm}>
            <FormGroup>
              <Label for="exampleUserName">UserName</Label>
              <Input type="text" name="UserName" id="exampleUserName" placeholder="UserName" onChange={(e)=>{
                  setuser({...user,userName:e.target.value});
              }} />
            </FormGroup>
            <FormGroup>
              <Label for="exampleEmail">Email</Label>
              <Input type="email" name="email" id="exampleEmail" placeholder="Email"  onChange={(e)=>{
                  setuser({...user,userEmail:e.target.value});
              }} />
            </FormGroup>
            <FormGroup>
              <Label for="examplePassword">Password</Label>
              <Input type="password" name="password" id="examplePassword" placeholder="password"  onChange={(e)=>{
                  setuser({...user,userPassword:e.target.value});
              }} />
            </FormGroup>
            <FormGroup>
              <Label for="exampleConatct">Conatct</Label>
              <Input type="text" name="Conatct" id="exampleConatct" placeholder="Conatct"  onChange={(e)=>{
                  setuser({...user,userContact:e.target.value});
              }} />
            </FormGroup>
            <Button className="position-relative start-50 my-2" color="primary">Submit</Button>
          </Form>
          </Col>
                </Row>
          </Container>
          );
      }

export default Register;