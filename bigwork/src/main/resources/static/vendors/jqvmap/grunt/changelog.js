<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7c6321057af5eb793477f23e9c635251ea586a49
module.exports = {
	release: {
		options: {
			insertType: "prepend",
			template: "## Release v<%= package.version %>:\n\n{{> features}}{{> fixes}}\n\n",
			partials: {
				features: "#### Features:\n\n{{#if features}}{{#each features}}{{> feature}}{{/each}}{{else}}{{> empty}}{{/if}}\n",
				fixes: "#### Bugfixes:\n\n{{#if fixes}}{{#each fixes}}{{> fix}}{{/each}}{{else}}{{> empty}}{{/if}}",
				empty: " - (none)\n"
			},
			dest: "CHANGELOG.md"
		}
	}
<<<<<<< HEAD
=======
=======
>>>>>>> a4ca7d44579152ae23b62615c248ef0f061358be
module.exports = {
	release: {
		options: {
			insertType: "prepend",
			template: "## Release v<%= package.version %>:\n\n{{> features}}{{> fixes}}\n\n",
			partials: {
				features: "#### Features:\n\n{{#if features}}{{#each features}}{{> feature}}{{/each}}{{else}}{{> empty}}{{/if}}\n",
				fixes: "#### Bugfixes:\n\n{{#if fixes}}{{#each fixes}}{{> fix}}{{/each}}{{else}}{{> empty}}{{/if}}",
				empty: " - (none)\n"
			},
			dest: "CHANGELOG.md"
		}
	}
<<<<<<< HEAD
=======
>>>>>>> 69dc794474d6d55bdb00ce5c53ea480a10f9fb00
>>>>>>> a4ca7d44579152ae23b62615c248ef0f061358be
>>>>>>> 7c6321057af5eb793477f23e9c635251ea586a49
};