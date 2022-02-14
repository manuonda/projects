import React, { useEffect, useState } from "react";
import { fetchWith } from "../services/fetchWithToken";
import { Link } from "react-router-dom";
export const ListBlog = () => {
  const [listado, setListado] = useState([]);

  const cargarData = async () => {
    const resp = await fetchWith("all", {}, "GET");
    const data = await resp.json();
    console.log(data);
    setListado(data);
  };
  useEffect(() => {
    cargarData();
  }, []);

  const handleDelete = ({ id }) => {
     console.log('delete : ', id);
  }

  return (
    <div className="container">
      <table className="table">
        <thead>
          <tr>ID</tr>
          <tr>Blog Title</tr>
          <tr>Acciones</tr>
        </thead>
        <tbody>
          {listado &&
            listado.map((blog) => (
              <>
                <tr key={blog.id}>
                  <td>{blog.id}</td>
                  <td>{blog.title}</td>
                  <td>
                    <Link
                      to={{
                        pathname: `/edit /${blog.id}`,
                        state: { blog },
                      }}
                      title="Editar"
                      className="mr-1 btn btn-primary"
                    >
                    Editar
                    </Link>
                    <button type="button" onClick={(ev) => handleDelete(blog.id)} className="mr-1 btn btn-secondary">Eliminar </button>
                  </td>
                </tr>
              </>
            ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListBlog;
