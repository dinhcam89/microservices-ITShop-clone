import { Routes,Route, BrowserRouter } from 'react-router-dom';
import Home from './page/Home/Home';
import ProductDetail from './page/ProductDetail/ProductDetail';
import Cart from './page/Cart/Cart';

export default function App() {
  return (
    <div className='App'>
      <div className='content'>
        <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home/>} />
          <Route path='/productdetail' element={<ProductDetail/>}/>
          <Route path='/shoppingcart' element={<Cart/>}/>
        </Routes>
        </BrowserRouter>
      </div>
    </div>
  )
}