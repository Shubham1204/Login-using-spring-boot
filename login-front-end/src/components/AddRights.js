import axios from 'axios';
import  {  useState } from 'react';
import {
    Container, Col, Form,
    FormGroup, Label, Input,
    Button, Row
  } from 'reactstrap';

const AddRights=()=>{
    
        const [right,setRight] = useState({});

    const handleForm =(e) =>{
console.log(right);
axios.post(`http://localhost:8080/authenticated/rights/add`,right).then(
(response)=>{
console.log(response.data);
 console.log(response.status)
if(response.status===200){
    console.log("right added success");
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
                    <h1 className="text-center">Add Rights Page</h1>
                    </Row>
                    <Row>
                    <Col>
            <Form onSubmit={handleForm}>
            <FormGroup>
              <Label for="exampleRightName">RightName</Label>
              <Input type="text" name="RightName" id="exampleRightName" placeholder="RightName" onChange={(e)=>{
                  setRight({...right,rightName:e.target.value});
              }} />
            </FormGroup>
            <FormGroup>
              <Label for="exampleRightDescription">RightDescription</Label>
              <Input type="text" name="RightDescription" id="exampleRightDescription" placeholder="RightDescription" onChange={(e)=>{
                  setRight({...right,rightDescription:e.target.value});
              }} />
            </FormGroup>
            <FormGroup>
              <Label for="exampleRightPath">RightPath</Label>
              <Input type="text" name="RightPath" id="exampleRightPath" placeholder="RightPath" onChange={(e)=>{
                  setRight({...right,rightPath:e.target.value});
              }} />
            </FormGroup>
            <Button className="position-relative start-50 my-2" color="primary">Submit</Button>
          </Form>
          </Col>
                </Row>
          </Container>
          );
      }

export default AddRights;