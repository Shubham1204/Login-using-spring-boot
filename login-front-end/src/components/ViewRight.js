
import { Card, CardText, CardTitle } from "reactstrap";

const ViewRight=({right})=>{

return(

    <Card body>
    <CardTitle tag="h5">Right Name : {right.rightName}</CardTitle>
    <CardText>Right Description : {right.rightDescription}</CardText>
    <CardText>Right Path : {right.rightPath}</CardText>
  </Card>

);
}

export default ViewRight;