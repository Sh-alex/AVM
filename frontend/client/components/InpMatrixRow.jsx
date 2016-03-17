import React from 'react';

import InpCell from './InpCell.jsx';

import './InpMatrixRow.less';

const InpMatrixRow = React.createClass({
    render() {
        let inpCellsA = [];
        for(let i=0; i < this.props.numOfX; i++){
            inpCellsA.push((
                <InpCell
                    className="inp-matrix__cell inp-matrix__cell-A"
                    coefficient={'•X'+(i+1)}
                    inputPlaceholder={'A'+(this.props.rowNum)+''+(i+1)}
                    key={'A'+(this.props.rowNum)+''+(i+1)}
                />
            ));
        }
        return (
            <tr className="inp-matrix__row">
                {inpCellsA}
                <td className="inp-matrix__cell">
                    <select className="inp-matrix__select inp-matrix__select--inequality-type">
                        <option value="above"> ≥ </option>
                        <option value="below"> ≤ </option>
                    </select>
                </td>
                <InpCell
                    className="inp-matrix__cell inp-matrix__cell-B"
                    coefficient={''}
                    inputPlaceholder={'B'+(this.props.rowNum)}
                />
            </tr>
        );
    }
});

export default InpMatrixRow;
