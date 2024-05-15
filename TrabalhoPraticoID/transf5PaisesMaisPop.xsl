<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<CincoPaisesMaisPopulosos>
			<xsl:for-each select="//pais">
				<xsl:sort select="number(populacao)" order="descending"/>
				<xsl:if test="position() &lt;= 5">
					<pais>
						<nome>
							<xsl:value-of select="nome"/>
						</nome>
						<populacao>
							<xsl:value-of select="populacao"/>
						</populacao>
						<capital>
							<xsl:value-of select="capital"/>
						</capital>
						<continente>
							<xsl:value-of select="continente"/>
						</continente>
						<moeda>
							<xsl:value-of select="moeda"/>
						</moeda>
						<Paises_Vizinhos>
							<xsl:for-each select="paises_vizinhos/pais_vizinho">
								<pais_vizinho>
									<xsl:value-of select="."/>
								</pais_vizinho>
							</xsl:for-each>
						</Paises_Vizinhos>
						<idiomas>
							<xsl:for-each select="idiomas/idioma">
								<idioma>
									<xsl:value-of select="."/>
								</idioma>
							</xsl:for-each>
						</idiomas>
					</pais>
				</xsl:if>
			</xsl:for-each>
		</CincoPaisesMaisPopulosos>
	</xsl:template>
</xsl:stylesheet>
