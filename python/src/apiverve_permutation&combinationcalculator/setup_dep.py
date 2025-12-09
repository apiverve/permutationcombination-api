from setuptools import setup, find_packages

setup(
    name='apiverve_permutation&combinationcalculator',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Calculate permutations (P(n,r)) and combinations (C(n,r)) for any given values of n and r.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
