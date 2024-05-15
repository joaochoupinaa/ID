<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="continente"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>Bandeiras dos Países do Continente</title>
			</head>
			<body>
				<h1>Bandeiras dos Países do Continente - 
					<xsl:value-of select="$continente"/>
				</h1>
				<table border="1">
					<tr>
						<th>País</th>
						<th>Bandeira</th>
					</tr>
					<xsl:apply-templates select="//pais[continente=$continente]"/>
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="pais">
		<tr>
			<td><xsl:value-of select="nome"/></td>
			<td>
				<img src="{bandeira}" alt="{nome} Bandeira" width="120" />
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>
