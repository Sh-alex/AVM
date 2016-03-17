import React from 'react';

import './InpCell.less';

const InpCell = React.createClass({
    render() {
        return (
            <td className={"inp-cell " + this.props.className}>
                <input className="inp-cell__input" type="number" placeholder={this.props.inputPlaceholder} required="required"/>
                <span className="inp-cell__coefficient"> {this.props.coefficient} </span>
            </td>
        );
    }
});
export default InpCell;
