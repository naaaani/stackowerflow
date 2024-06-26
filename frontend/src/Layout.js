import { Outlet, Link } from "react-router-dom";



const Layout = () => (
  <div className="Layout">
    <nav>
      <ul>
        <li className="grow">
          <Link to="/">Questions</Link>
        </li>
        <li>
          <Link to="/create-question">
            <button type="button">New question</button>
          </Link>
        </li>
      </ul>
    </nav>
    <Outlet />
  </div>
);

export default Layout;
