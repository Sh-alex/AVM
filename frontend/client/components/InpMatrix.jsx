import React from 'react';

import InpMatrixRow from './InpMatrixRow.jsx';

import './InpMatrix.less';

const InpMatrix = React.createClass({
    render() {
        let inpRows =[];
        for(let i=0; i < this.props.numOfRestrictions; i++){
            inpRows.push((
                <InpMatrixRow
                    rowNum={i+1}
                    numOfX={this.props.numOfX}
                    key={"row"+(i+1)}
                />
            ));
        }
        return (
            <div className="form-group inp-matrix">
                <strong> Введіть значення матриці: </strong>
                <div className="table-responsive inp-matrix__table-wrapper">
                    <table className="table inp-matrix__table">
                        <tbody>
                        {inpRows}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
});
export default InpMatrix;
