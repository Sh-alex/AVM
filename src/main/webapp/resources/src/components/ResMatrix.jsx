import React from 'react';

//import Header from './Header.jsx';

import './InitialDataForm.less';

const InitialDataForm = React.createClass({
    makeMatrixTable(){
        let bVars = this.props.resMatrixData.basicVariables,
            notBVars = this.props.resMatrixData.notBasicVariables,
            matrix = this.props.resMatrixData.matrix;
        if(!bVars || !notBVars || !matrix)
            return (<tr className="res-matrix__row">
                        <td> Таблиця пуста </td>
                   </tr>);
        return matrix.map( (row, i) => {
            let result = [];
            if(i === 0)
                result.push((
                    <tr className="res-matrix__row">
                        <th> </th>
                        {notBVars.map(notBVar => (<th> {notBVar} </th>))}
                    </tr>
                ));
            result.push((
                <tr className="res-matrix__row">
                    <th> { bVars[i] } </th>
                    {row.map(el => (<td> <span className="matrix-result-cell"> {el} </span> </td>))}
                </tr>
            ));
            return result;
        });
    },
    render() {
        return (
            <div className="res-matrix">
                <p> <strong>Матриця результатів:</strong> </p>
                <div className="res-matrix__table-wrapper table-responsive">
                    <table className="table table-striped table-bordered res-matrix__table">
                        <tbody>
                        { this.makeMatrixTable() }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
});
export default InitialDataForm;
