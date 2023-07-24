import React, { Component } from "react";
import { Navbar, NavbarBrand } from "reactstrap";
import { Link } from "react-router-dom";
import { MDBIcon } from "mdb-react-ui-kit";

export default class AppNavbar extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <Navbar color="dark" dark expand="md">
        <NavbarBrand>
          <MDBIcon fas icon="check-double" />
          Todo2
        </NavbarBrand>
      </Navbar>
    );
  }
}
