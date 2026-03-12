import Header from "./components/Header";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  // const [count, setCount] = useState(0)

  return (
    <>
    <Header/>
    <Home/>
    <Footer/>
    
    </>
  )
}

export default App
