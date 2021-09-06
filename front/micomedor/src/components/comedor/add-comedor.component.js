import React, { Component } from "react";
import ComedorDataService from "../../services/comedor/comedor.service";

export default class AddComedor extends Component {
  constructor(props) {
    super(props);
    this.onChangeNombre = this.onChangeNombre.bind(this);
    this.onChangeDireccion = this.onChangeDireccion.bind(this);
    this.onChangeCorreo = this.onChangeCorreo.bind(this);
    this.onChangeTelefono = this.onChangeTelefono.bind(this);
    this.saveComedor = this.saveComedor.bind(this);
    this.newComedor = this.newComedor.bind(this);

    this.state = {
      id: null,
      nombre: "",
      direccion: "",
      correo: "",
      telefono: 0,
    };
  }

  onChangeNombre(e) {
    this.setState({
      nombre: e.target.value,
    });
  }

  onChangeDireccion(e) {
    this.setState({
      direccion: e.target.value,
    });
  }
  onChangeCorreo(e) {
    this.setState({
      correo: e.target.value,
    });
  }
  onChangeTelefono(e) {
    this.setState({
      telefono: e.target.value,
    });
  }

  saveComedor() {
    var data = {
      nombre: this.state.nombre,
      direccion: this.state.direccion,
      correo: this.state.correo,
      telefono: this.state.telefono,
    };

    ComedorDataService.create(data)
      .then((response) => {
        this.setState({
          id: response.data.id,
          nombre: response.data.nombre,
          direccion: response.data.direccion,
          correo: response.data.correo,
          telefono: response.data.telefono,
        });
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  newComedor() {
    this.setState({
      id: null,
      nombre: "",
      direccion: "",
      correo: "",
      telefono: 0,
    });
  }
  render() {
    return (
      <div className="submit-form">
        {this.state.submitted ? (
          <div>
            <h4> El comedor se ha creado correctamente. </h4>
            <button className="btn btn-success">Agregar</button>
          </div>
        ) : (
          <div>
            <div className="form-group">
              <label htmlFor="nombre"> Nombre</label>
              <input
                type="text"
                className="form-control"
                id="nombre"
                required
                value={this.state.nombre}
                onChange={this.onChangeNombre}
                name="nombre"
              />
            </div>
            <div className="form-group">
              <label htmlFor="direccion">Direccion</label>
              <input
                type="text"
                className="form-control"
                id="direccion"
                required
                value={this.state.direccion}
                onChange={this.onChangeDireccion}
                name="direccion"
              />
            </div>
            <div className="form-group">
              <label htmlFor="correo">Correo</label>
              <input
                type="text"
                className="form-control"
                id="correo"
                required
                value={this.state.correo}
                onChange={this.onChangeCorreo}
                name="correo"
              />
            </div>
            <div className="form-group">
              <label htmlFor="telefono">Telefono</label>
              <input
                type="number"
                size="12"
                className="form-control"
                id="telefono"
                required
                value={this.state.telefono}
                onChange={this.onChangeTelefono}
                name="telefono"
              />
            </div>
            <button onClick={this.saveComedor} className="btn btn-success">
              Agregar
            </button>
          </div>
        )}
      </div>
    );
  }
}
