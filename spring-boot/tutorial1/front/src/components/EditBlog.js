import React ,{useEffect , useState} from "react";
import { Field, Formik, Form } from "formik";
import { Link, useParams , useNavigate } from 'react-router-dom';
import { fetch , fetchWith} from '../services/fetchWithToken';



export const EditBlog = (props) => {
  const { id } = useParams();

  const navigate = useNavigate(); 
  const initValues =  {
    id: null,
    blogName: "",
    description: "",
  };

  const [initialValues, setInitialValues] = useState("");

  useEffect(() => {
    console.log('Edit Cid => ', id )  
    const cargarData  = async () => {
      const resp = await fetchWith(`blog/${id}`,{},'GET');  
      const data = await resp.json();
      initValues.blogName =  data.blogName;
      initValues.description = data.description;
      console.log('Edit data data : ', data);
      Object.assign(initValues, data);
      setInitialValues(data);
    }
    cargarData();
  }, [id])

  const validate = (values) => {
    const errors = {};
    if (!values.blogName) {
      errors.blogName = "Requerido";
    } else if (values.blogName.length < 5) {
      errors.blogName = "Debe ingresar minimo 5 caracteres";
    }
    return errors;
  };

  const onSubmit = async (values) => {
        console.log(values);
        try {
          const data = {
            blogName :  values.blogName,
            description :  values.description,
            id: values.id
          }
          const resp  = await fetchWith(`update/${values.id}`, data, "PUT");
          if(resp.status === 200 ) {
              navigate("/", {news: true});
          } else  {
            alert("Error");
          }
          console.log('response server : ', resp);
        } catch (error) {
           console.error(error);
        }
  };

  console.log(initValues);
  return (
    <div>
      <Formik
        initialValues={{
          blogName :  initialValues.blogName,
          description :  initialValues.description,
          id : initialValues.id
        }}
        onSubmit={onSubmit}
        validate={validate}
        enableReinitialize
      >
        { formik => (
          <Form>
              blogName : {formik.values.blogName}
            <div className="form-group">
              <label>blogName</label>
              <Field 
                    name="blogName" 
                    value={formik.values.blogName}
                    className="form-control"/>

              { formik.errors && formik.errors.blogName && formik.touched.blogName ? (
                <div className="danger">{formik.errors.blogName}</div>
              ) : null}
            </div>

            <div className="form-group">
                <label>Description</label>
                <Field name="description" 
                       className="form-control" 
                       type="textarea"></Field>
            </div>
            <Link to={'/'} className="btn btn-secondary">Volver</Link>
            <button type="submit" className="btn btn-primary">Enviar</button>
          </Form>
        )}
      </Formik>
    </div>
  );
};

export default EditBlog;
