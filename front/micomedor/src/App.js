import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

import AddComedor from "./components/comedor/add-comedor.component";
import Comedor from "./components/comedor/comedor.component";
import ComedoresList from "./components/comedor/comedor-list.component";

class App extends Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <a href="/comedores" className="navbar-brand">
            MiComedor
          </a>
          <div className="navbar-nav mr-auto">
           {/*  <li className="nav-item">
              <Link to={"/comedores"} className="nav-link">
                Comedores
              </Link>
            </li> */}
            <li className="nav-item">
              <Link to={"/agregarComedor"} className="nav-link">
                Agregar
              </Link>
            </li>
          </div>
        </nav>
        <div className="container mt-3">
          <Switch>
            {/* <Route exact path={["/", "/comedores"]} component={ComedoresList} /> */}
            <Route exact path="/agregarComedor" component={AddComedor} />
           {/*  <Route exact path="/comedores/:id" component={Comedor} /> */}
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
