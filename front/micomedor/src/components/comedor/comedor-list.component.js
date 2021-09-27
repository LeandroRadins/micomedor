import React, { Component } from "react";
import ComedorDataService from "../../services/comedor/comedor.service";
import { Link } from "react-router-dom";
export default class ComedoresList extends Component {
  constructor(props) {
    super(props);
    this.onChangeSearchNombre = this.onChangeSearchNombre.bind(this);
    this.recuperarComedores = this.recuperarComedores.bind(this);
    this.refrescarLista = this.refrescarLista.bind(this);
    this.setActiveComedor = this.setActiveComedor.bind(this);
    this.removeAllComedores = this.removeAllComedores.bind(this);
    this.searchNombre = this.searchNombre.bind(this);

    this.state = {
      comedores: [],
      currentComedor: null,
      currentIndex: -1,
      searchNombre: "",
    };
  }

  componentDidMount() {
    this.recuperarComedores();
  }

  onChangeSearchNombre(e) {
    const searchNombre = e.target.value;
    this.setState({
      searchNombre: searchNombre,
    });
  }

  recuperarComedores() {
    ComedorDataService.getAll()
      .then((response) => {
        this.setState({
          comedores: response.data,
        });
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  refrescarLista() {
    this.recuperarComedores();
    this.setState({
      currentComedor: null,
      currentIndex: -1,
    });
  }

  setActiveComedor(comedor, index) {
    this.setState({
      currentComedor: comedor,
      currentIndex: index,
    });
  }

  removeAllComedores() {
    ComedorDataService.deleteAll()
      .then((response) => {
        console.log(response.data);
        this.refrescarLista();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  searchNombre() {
    ComedorDataService.findByNombre(this.state.searchNombre)
      .then((response) => {
        this.setState({
          comedores: response.data,
        });
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  render() {
    const { searchNombre, comedores, currentComedor, currentIndex } =
      this.state;
    return (
      <div className="list-row">
        <div className="col-md-8">
          <div className="input-grouo mb-3">
              <input
                type="text"
                className = "form-control"
                placeholder="Buscar por nombre"
                value = {searchNombre}
                onChange = {this.onChangeSearchNombre}
              />
              <div className="input-group-append">
                  <button className="btn btn-outline-secondary" type="button" onClick={this.searchNombre}>
                      Buscar
                  </button>
              </div>
          </div>
        </div>
      </div>
    );
  }
}
