import http from "../../http-common";

class ComedorDataService {
  getAll() {
    return http.get("/comedores");
  }

  get(id) {
    return http.get(`/comedores/${id}`);
  }

  create(data) {
    return http.post("/comedores", data);
  }

  update(id, data) {
    return http.put(`/comedores/${id}`, data);
  }

  delete(id) {
    return http.delete(`/comedores/${id}`);
  }

  deleteAll() {
    return http.delete("/comedores");
  }

  findByNombre(nombre) {
    return http.get(`/comedores?nombre=${nombre}`);
  }
}

export default new ComedorDataService();
