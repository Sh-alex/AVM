import React from 'react';

import './InpMatrixInpCell.less';

const InpMatrixInpCell = React.createClass({
    render() {
        return (
            <td className="inp-matrix__cell inp-matrix__inp-cell">
                <input className="inp-matrix__input" type="number" value="" placeholder="C1" />
                <span className="inp-matrix__text"> •X<sub>1</sub> </span>
            </td>
        );
    }
});
export default InpMatrixInpCell;
