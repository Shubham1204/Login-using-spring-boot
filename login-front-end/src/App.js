import './App.css';
import Header from './components/Header';
import Login from './components/Login';
import Register from './components/Register';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import AddRights from './components/AddRights';
import ViewRights from './components/ViewRights';
import Profile from './components/Profile';
import VerifyUser from './components/VerifyUser';

function App() {
   
  return (
    <div >
        <Router>
      <Header />
        <Route path="/login" ><Login /></Route>
        <Route path="/register" ><Register  /></Route>
        <Route path="/rights/add" ><AddRights  /></Route>
        <Route path="/rights/view" ><ViewRights  /></Route>
        <Route path="/profile"  ><Profile /></Route>
        <Route path="/verify"  ><VerifyUser /></Route>
        </Router>
    </div>
  );
}

export default App;
