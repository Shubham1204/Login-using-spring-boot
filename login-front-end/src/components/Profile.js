import { useEffect, useState } from "react";
import { Card, CardText, CardTitle } from "reactstrap";


const Profile = ()=>{
    const [user,setUser] = useState({});
   
useEffect(()=>{
    setUser(JSON.parse(localStorage.getItem("user")));
     
},[]);

return(
    <div>
 
        <Card body>
            {/* {console.log("user",user.userName)} */}
          <CardTitle tag="h5">{user.userName}</CardTitle>
          <CardText>{user.userEmail}</CardText>
          <CardText>{user.userContact}</CardText>
          <CardText>{user.userPassword}</CardText>

          
        </Card>
    </div>
);
}

export default Profile;