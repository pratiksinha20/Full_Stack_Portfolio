// // import logo from "../assets/logo.png";
// function Header() {
// {
//     return (
//         <header>
//             <h2>Pratik Kumar Sinha</h2>
//             {/* <img src={logo} alt="Pratik Kumar Sinha" width="100" height="100" /> */}
//         </header>
//     );
// }
// export default Header;
import logo from "JobPortal/src/assets/PratikPic.png";
function Header() {
  return (
    <nav style={{display:"flex", alignItems:"center", gap:"10px"}}>
      <img src={logo} alt="Pratik Kumar Sinha" width="100" height="100" />
      <h2>My Website</h2>
    </nav>
  );
}

export default Header;