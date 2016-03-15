import React from 'react';

import InpMatrixRow from './InpMatrixRow.jsx';

import './InpMatrix.less';

const InpMatrix = React.createClass({
    render() {
        return (
            <div className="form-group inp-matrix">
                <strong> Введіть значення матриці: </strong>
                <div className="table-responsive inp-matrix__table-wrapper">
                    <table className="table inp-matrix__table">
                        <tbody>
                            <InpMatrixRow />
                            <InpMatrixRow />
                            <InpMatrixRow />
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
});
export default InpMatrix;
