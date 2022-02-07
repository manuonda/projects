import React from 'react'
import { Link} from "react-router-dom";

export const MenuBar = () => {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-dar bg-bg">
                <div className="container-fluid">
                    <Link className="navbar-brand font-ch"  to="/">BLOG APP</Link>
                </div>
            </nav>
        </div>
    )
}


export default MenuBar;