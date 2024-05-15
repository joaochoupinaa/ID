xquery version "1.0";

<populacao_continente>
{
    for $continente in distinct-values(doc("factos.xml")//continente)
    return 
        <continente>
            <nome>{$continente}</nome>
            <populacao_total>{
                sum(doc("factos.xml")//pais[continente = $continente]/populacao)
            }</populacao_total>
        </continente>
}
</populacao_continente>

