import {useState} from 'react';
import { Link } from 'react-router-dom';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    NavbarText
  } from 'reactstrap';

function Header(){

  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

    return(
        <div>
        <Navbar color="light" light expand="md">
          <NavbarBrand href="/" className="mx-5">Logo</NavbarBrand>
          <NavbarToggler onClick={toggle} />
          <Collapse isOpen={isOpen} navbar>
            <Nav className="mx-auto" navbar>
            <NavItem>
                <NavLink>Home</NavLink>
              </NavItem>
              <NavItem>
                <NavLink><Link to="/login">Login</Link></NavLink>
              </NavItem>
              <NavItem>
                <NavLink><Link to="/register">Register</Link></NavLink>
              </NavItem>
              <NavItem>
                <NavLink><Link to="/rights/add">Add Right</Link></NavLink>
              </NavItem>
              <NavItem>
                <NavLink><Link to="/rights/view">View Rights</Link></NavLink>
              </NavItem>
              
            </Nav>
            <NavbarText className="mx-auto">Welcome</NavbarText>
          </Collapse>
        </Navbar>
      </div>
    )}

export default Header;