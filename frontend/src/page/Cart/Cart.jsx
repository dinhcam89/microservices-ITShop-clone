import React from 'react'
import CartItem from './components/CartItem';
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';

const Cart = () => {
  const cartItems = [
    {
      name: "Apple Airpod",
      description: "hahahaha",
      price: 32,
      inStock: true,
      image: "https://images.unsplash.com/photo-1629367494173-c78a56567877?ixlib=rb-4.0.3&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=927&amp;q=80", // Replace with actual image link
    },
    {
      name: "Apple Airpod",
      price: 32,
      description: "hahahaha",
      inStock: false,
      image: "https://images.unsplash.com/photo-1629367494173-c78a56567877?ixlib=rb-4.0.3&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=927&amp;q=80", // Replace with actual image link
    },
    {
      name: "Apple Airpod",
      description: "hahahaha",
      price: 32,
      inStock: true,
      image: "https://images.unsplash.com/photo-1629367494173-c78a56567877?ixlib=rb-4.0.3&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=927&amp;q=80", // Replace with actual image link
    },
  ];

  const subtotal = cartItems.reduce((total, item) => total + item.price, 0);

  return (
    <div >
      <Navbar/>
      <div className="min-h-screen bg-gray-100 flex justify-center items-center p-4">
        <div className="bg-white shadow-lg rounded-lg p-8 w-full max-w-2xl">
          <h1 className="text-2xl font-semibold mb-6">Shopping Cart</h1>
          
          {/* Cart Item */}
          {
            cartItems.map((item,index)=>(
              <CartItem item={item} key={index}/>
            ))
          }

          {/* Subtotal */}
          <div className="flex justify-between items-center mt-6 border-t pt-4">
            <p className="text-lg font-medium">Subtotal</p>
            <p className="text-lg font-medium">${subtotal.toFixed(2)}</p>
          </div>
          <p className="text-sm text-gray-500">Shipping and taxes will be calculated at checkout.</p>

          {/* Checkout Button */}
          <div className="mt-6">
            <button className="bg-purple-600 text-white py-3 px-6 rounded-md w-full text-center">
              Checkout
            </button>
          </div>

          {/* Continue Shopping */}
          <div className="mt-4 text-center">
            <a href="http://localhost:3000/" className="text-purple-500">or Continue Shopping →</a>
          </div>
        </div>
      </div>
       <Footer/>   
    </div>
  );
}

export default Cart