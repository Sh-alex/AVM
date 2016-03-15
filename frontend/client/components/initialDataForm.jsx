import React from 'react';

import InpNumOfVars from './InpNumOfVars.jsx';
import InpMatrix from './InpMatrix.jsx';
import OptFunc from './OptFunc.jsx';

import './InitialDataForm.less';

const InitialDataForm = React.createClass({
    render() {
        return (
            <form className="initial-data-form">
                <InpNumOfVars />
                <InpMatrix />
                <OptFunc />
                <div className="form-group text-center">
                    <button type="submit" className="btn btn-primary">Порахувати</button>
                </div>
            </form>
        );
    }
});

export default InitialDataForm;
