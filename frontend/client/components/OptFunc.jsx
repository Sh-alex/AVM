import React from 'react';

import InpCell from './InpCell.jsx';

import './OptFunc.less';

const OptFunc = React.createClass({
    render() {
        let inpCells = [];
        for(let i=0; i < this.props.numOfX; i++){
            inpCells.push((
                <InpCell
                    className="opt-func__cell"
                    coefficient={'•X'+(i+1)}
                    inputPlaceholder={'C'+(i+1)}
                    key={'C'+(i+1)}
                />
            ));
        }
        return (
            <div className="form-group opt-func">
                <strong> Цільова функція: </strong>
                <div className="table-responsive opt-func__table-wrapper">
                    <table className="table opt-func__table">
                        <tbody>
                        <tr className="opt-func__row">
                            {inpCells}
                            <td className="opt-func__cell">
                                <span> → </span>
                            </td>
                            <td className="opt-func__cell">
                                <select title="Критерій оптимізації" className="opt-func__select-criterion">
                                    <option value="min"> min </option>
                                    <option value="max"> max </option>
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
