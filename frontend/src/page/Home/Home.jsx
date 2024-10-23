import React from 'react'
import Navbar from '../../components/Navbar'
import ItemCard from './components/ItemCard'
import TypeSelectBar from './components/TypeSelectBar'
import Footer from '../../components/Footer'
import Carousel from './components/Carousel'
const Home = () => {
  return (
    <div className='pt-24'>
        <Navbar />
        <Carousel/>
        <div className='flex flex-row  mx-6 md:mx-20'>
            <div className='flex-none mx-5 hidden md:block'>
                <TypeSelectBar/>
            </div>

            <div className='grow mx-5 px-5 py-6'>
                <div className='flex flex-col bg-white shadow-sm border border-slate-200 rounded-lg px-5 py-2'>
                    <div className='font-bold text-xl font-[Poppins] md:text-2xl '>SẢN PHẨM NỔI BẬT</div>
                    <div className='grid grid-cols-1 md:grid-cols-2  lg:grid-cols-3    '>
                        <ItemCard/>
                        <ItemCard/>
                        <ItemCard/>
                        <ItemCard/>
                        <ItemCard/>
                        <ItemCard/>
                        <ItemCard/>
                        <ItemCard/>
                    </div>
                </div>
            </div>  
        </div>
        <Footer/>
    </div>
  )
}

export default Home