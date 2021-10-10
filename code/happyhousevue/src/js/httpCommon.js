import axios from "axios";

export default {
  axios: axios.create({
    baseURL: "http://localhost:8090/happy",
    headers: {
      "Content-Type": "application/json",
    },
  }),
};
