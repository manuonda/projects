import React from "react";
import { Field, Formik, Form } from "formik";
import { Link } from 'react-router-dom';
import { fetch , fetchWith} from '../services/fetchWithToken';
import { useNavigate } from 'react-router-dom';

export const CreateBlog = () => {
  const initValues = {
    blogName: "",
    description: "",
  };


  const navigate = useNavigate();
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
            description :  values.description
          }
          const resp  = await fetchWith('create', data, "POST");
          
          navigate('/', { news: true});
        } catch (error) {
           console.error(error);
        }
  };

  console.log(initValues);
  return (
    <div>
      <Formik
        initialValues={initValues}
        onSubmit={onSubmit}
        validate={validate}
      >
        { formik => (
          <Form>
            <div className="form-group">
              <label>blogName</label>
              <Field name="blogName" 
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

export default CreateBlog;
