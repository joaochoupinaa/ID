xquery version "1.0";

let $factos := doc("factos.xml")//factos
let $paises := doc("paises.xml")//paises

return 
<result>
  {
    for $pais in $paises/pais
    let $codigoISO := $pais/@CodigoISO
    let $facto := $factos/pais[@CodigoISO = $codigoISO]
    return 
    <pais>
        <codigoISO>{$codigoISO}</codigoISO>
        <nome>{$pais/nome/text()}</nome>
        <continente>{$pais/continente/text()}</continente>
        <presidente>{$pais/presidente/text()}</presidente>
        <bandeira>{$pais/bandeira/text()}</bandeira>
        <populacao>{$facto/populacao/text()}</populacao>
        <area>{$facto/area/text()}</area>
        <crescimentoPopulacional>{$facto/crescimentoPopulacional/text()}</crescimentoPopulacional>
        <cidades_mais_populosas>
			{
				for $cidade in $facto/cidades_mais_populosas/cidade
				return
				<cidade>{ $cidade/text() }</cidade>
			}
		</cidades_mais_populosas>
        <dominioInternet>{$facto/dominioInternet/text()}</dominioInternet>
        <idiomas>
			{
				for $idioma in $facto/idiomas/idioma
				return
				<idioma>{ $idioma/text() }</idioma>
			}
		</idiomas>
        <paises_vizinhos>
			{
				for $pais_vizinho in $facto/paises_vizinhos/pais_vizinho
				return
				<pais_vizinho>{ $pais_vizinho/text() }</pais_vizinho>
			}
		</paises_vizinhos>
    </pais>
  }
</result>
