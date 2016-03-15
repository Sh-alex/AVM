import React from 'react';

//import Header from './Header.jsx';

import './InitialDataForm.less';

const InitialDataForm = React.createClass({
    render() {
        return (
            <div className="res-matrix">
                <p> <strong>Матриця результатів:</strong> </p>
                <div className="res-matrix__table-wrapper table-responsive">
                    <table className="table table-striped table-bordered res-matrix__table">
                        <tbody>
                        <tr className="res-matrix__row">
                            <th> </th>
                            <th> X<sub>2</sub> </th>
                            <th> X<sub>7</sub> </th>
                            <th> X<sub>6</sub> </th>
                            <th> X<sub>4</sub> </th>
                            <th> Базис </th>
                        </tr>
                        <tr>
                            <th> X<sub>5</sub> </th>
                            <td>
                                <span className="matrix-result-cell"> 6 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 0.3 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 0.2 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 6.6 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> -1.9 </span>
                            </td>
                        </tr>
                        <tr>
                            <th> X<sub>3</sub> </th>
                            <td>
                                <span className="matrix-result-cell"> 6 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 0.3 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 0.2 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 6.6 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> -1.9 </span>
                            </td>
                        </tr>
                        <tr>
                            <th> X<sub>1</sub> </th>
                            <td>
                                <span className="matrix-result-cell"> 6 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 0.3 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 0.2 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 6.6 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> -1.9 </span>
                            </td>
                        </tr>
                        <tr>
                            <th>F</th>
                            <td>
                                <span className="matrix-result-cell"> 6 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 0.3 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 0.2 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> 6.6 </span>
                            </td>
                            <td>
                                <span className="matrix-result-cell"> -1.9 </span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
});
export default InitialDataForm;
