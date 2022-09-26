var conteiner = document.getElementById("root");

// function Titulo(props ) {

//     return (

//         <React.Fragment>

//             <h1>{props.texto} </h1>
//             <h1>{props.idade} </h1>
            
//         </React.Fragment>

//     )
// }

// function Titulos() {
//     return(
//         <>
//         <Titulo texto="1º título" />
//         <Titulo texto="2º título" />        
//         <Titulo idade="3º título" />

//         </>
//     )
// }
var contador = 0 
function votar() {
    setContador(contador + 1)
    console.log(contador)
}

function Participante(props) {
    const {contador, setContador = React.useState(0)};
    return(
        <>
        <h1>{props.nome}</h1>
        <h3>votos: {contador}</h3>
        <button onClick={votar}>Votar</button>

        </>
    )
}

function Votacao() {
    return(
        <>
        <Participante nome="Méqui" />
        <Participante nome="BK" />
        <Participante nome="Papais" />
        </>
    )
}

ReactDOM.createRoot(conteiner).render(<Participante />)