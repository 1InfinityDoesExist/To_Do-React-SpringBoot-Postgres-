import React from "react";

export default function Navbar() {
  return (
    <nav
      className="navbar navbar-expand-sm navbar-dark bg-primary mb-4"
      role="navigation"
    >
      <div className="container-topnav">
        <ul>
          <li>
            <a className="navbar-brand" href="/">
              Project Task Tool
            </a>
          </li>
          <li>
            <a className="navbar-brand" href="/Form">
              Form
            </a>
          </li>
        </ul>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#mobile-nav"
        >
          <span className="navbar-toggler-icon" />
        </button>
      </div>
    </nav>
  );
}
