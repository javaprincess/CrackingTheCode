
<script src="https://facebook.github.io/react/js/jsfiddle-integration.js"></script>


var ProductCategoryRow = React.createClass({
    render: function() {
        return (<tr><th colSpan="2">{this.props.category}</th></tr>);
    }
});

var ProductRow = React.createClass({
    render: function() {
        var name = this.props.product.stocked ?
            this.props.product.name :
            <span style={{color: 'red'}}>
                {this.props.product.name}
            </span>;
        return (
            <tr>
                <td>{name}</td>
                <td>{this.props.product.price}</td>
            </tr>
        );
    }
});

var ProductTable = React.createClass({
    render: function() {
        var rows = [];
        var lastCategory = null;
        this.props.products.forEach(function(product) {
            if (product.category !== lastCategory) {
                rows.push(<ProductCategoryRow category={product.category} key={product.category} />);
            }
            rows.push(<ProductRow product={product} key={product.name} />);
            lastCategory = product.category;
        });
        return (
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>
        );
    }
});

var SearchBar = React.createClass({
    render: function() {
        return (
            <form>
                <input type="text" placeholder="Search..." />
                <p>
                    <input type="checkbox" />
                    {' '}
                    Only show products in stock
                </p>
            </form>
        );
    }
});

var FilterableProductTable = React.createClass({
    render: function() {
        return (
            <div>
                <SearchBar />
                <ProductTable products={this.props.products} />
            </div>
        );
    }
});


var PRODUCTS = [
  {category: 'Upcoming Games', price: 'tomorrow', stocked: true, name: 'Breakers vs Legacy FC'},
  {category: 'Upcoming Games', price: 'tomorrow', stocked: true, name: 'Breakers vs Sand and Surf '},
  {category: 'Upcoming Games', price: 'tomorrow', stocked: false, name: 'Kryptonite vs West LA'},
  {category: 'Past Games', price: 'yesterday', stocked: true, name: 'Kryptonite vs Ontario'},
  {category: 'Past Games', price: 'yesterday', stocked: false, name: 'Eagles vs Culver City'},
  {category: 'Past Games', price: 'yesterday', stocked: true, name: 'Breakers vs Santa Monica United'}
];
 
React.render(<FilterableProductTable products={PRODUCTS} />, document.body);