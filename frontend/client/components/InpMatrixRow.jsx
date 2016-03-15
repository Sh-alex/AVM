import React from 'react';

import InpMatrixInpCell from './InpMatrixInpCell.jsx';

import './InpMatrixRow.less';

const InpMatrixRow = React.createClass({
    render() {
        return (
            <tr className="inp-matrix__row">
                <InpMatrixInpCell />
                <InpMatrixInpCell />

                <td className="inp-matrix__cell">
                    <select className="inp-block__select inp-matrix__select">
                        <option value="above"> ≥ </option>
                        <option value="below" selected> ≤ </option>
                    </select>
                </td>
                <td className="inp-matrix__cell">
                    <input className="inp-matrix__input" type="number" value="" placeholder="B1"/>
                </td>
            </tr>
        );
    }
});

export default InpMatrixRow;
