
import axios from "axios";
import { useEffect, useState } from "react";
import { Col, Container, Row } from "reactstrap";
import ViewRight from "./ViewRight";

const ViewRights=()=>{
 useEffect(()=>{
     getAllRights();
 },[])
    const [rights,setRights] = useState([]);

    const getAllRights =()=>{
        axios.get(`http://localhost:8080/authenticated/rights/getAll`).then(
            (response)=>{
                console.log(response.data);
                setRights(response.data);
            },
            (error)=>{
console.log(error);
            });
    }

return(
    <Container>
        <Row>
            <Col>
            <h1 className="text-center">Rights</h1>
            </Col>
            </Row>
            <Row>
            <Col>
    {rights.length>0 ? rights.map((item) => <ViewRight right={item} /> ) : <h1>No Right Avaliable</h1>}
  </Col>
        </Row>
  </Container>
);
}

export default ViewRights;