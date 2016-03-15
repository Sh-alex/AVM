import React from 'react';

import InitialDataForm from './InitialDataForm.jsx';
import ResMatrix from './ResMatrix.jsx';

import './MainBlock.less';

const MainBlock = React.createClass({
    render() {
        return (
            <main className="container-fluid main-block">
                <div className="input-column">
                    <div className="input-block">
                        <InitialDataForm />
                    </div>
                </div>
                <div className="results-column">
                    <div className="results-block">
                        <ResMatrix/>
                    </div>
                </div>
            </main>
        );
    }
});

export default MainBlock;