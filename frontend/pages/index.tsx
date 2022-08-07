import styles from '../styles/Home.module.css'

export default function Home({data}:any) {

  const {cardName, cardImage, password, budget} = data

  let realBRL = Intl.NumberFormat("pt-BR", {
    style: "currency",
    currency: "BRL",
});

  return (
    <div className="bg-[#0e0e0e] min-w-full min-h-screen text-white flex flex-col gap-10 items-center justify-center">
      <img className="w-56 border rounded-xl bg-white" src={cardImage} alt="Imagem do cartão c6 Bank" />
      <h1 className="text-2xl font-bold">{cardName}</h1>
      <div className="text-3xl flex flex-col items-center gap-4">
      <span>Senha: {password}</span>
      <span>Saldo: <span className="text-[#1b7213]">{realBRL.format(budget)}</span></span>
      </div>  
    </div>
  )
}

export async function getServerSideProps() {
  const url = process.env.URL || ""

  const res = await fetch(url)
  const data = await res.json()

  return { props: { data } }
}