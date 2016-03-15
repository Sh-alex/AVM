import React from 'react';

import InpMatrixInpCell from './InpMatrixInpCell.jsx';

import './OptFunc.less';

const OptFunc = React.createClass({
    render() {
        return (
            <div className="form-group opt-func">
                <strong> Цільова функція: </strong>
                <div className="table-responsive opt-func__table-wrapper">
                    <table className="table opt-func__table">
                        <tbody>
                        <tr className="opt-func__row">
                            <InpMatrixInpCell className="opt-func__cell"/>
                            <InpMatrixInpCell className="opt-func__cell"/>

                            <td className="opt-func__cell">
                                <span> → </span>
                            </td>
                            <td className="opt-func__cell">
                                <select title="Критерій оптимізації" className="inp-block__select opt-func__select-criterion">
                                    <option value="min"> min </option>
                                    <option value="max" selected> max </option>
                                </select>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
});
export default OptFunc;
