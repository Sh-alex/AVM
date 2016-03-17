import React from 'react';

import Header from '../Header.jsx';
import Footer from '../Footer.jsx';
import MainBlock from '../MainBlock.jsx';

import './App.less';

const App = React.createClass({
    render() {
        return (
            <div className="App">
                <Header />
                <MainBlock />
                <Footer />
            </div>
        );
    }
});

export default App;